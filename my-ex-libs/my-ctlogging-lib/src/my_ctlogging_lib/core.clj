(ns my-ctlogging-lib.core
    (:require
          [clojure.tools.logging :as log]
          
          ;;;For this demo:
          [clojure.pprint :as pp :refer [cl-format]]
          ;;;;;;
          
           ))




;;; The following macros and functions can come handy when the original library was printing outputs to stdout
;;; and you want to print to log instead, with minimal disruption to the code.
;; https://clojuredocs.org/clojure.core/with-out-str
(defmacro with-out-str-dm "returns a data map with a key for the results and another for the output string"
  [& body]
  `(let [s# (new java.io.StringWriter)]
     (binding [*out* s#]
       (let [r# ~@body]
         {:result r#
          :strn    (str s#)}))))


(defmacro wrnlog-info-log "returns the result, logs the output string as info. Uses clojure.tools.logging."
  [& body]
  `(let [s# (new java.io.StringWriter)]
     (binding [*out* s#]
       (let [r# ~@body]
         (do (log/info (str s#))
             r#) ))))

;;;;



(defn println-wrnlog-info-log "println replacement. Returns the result, logs the output string as info. Uses clojure.tools.logging."
[& more] (->> (apply println more)(wrnlog-info-log))  )


(defn cl-format-wrnlog-info-log "returns the result, logs the output string as info. Uses clojure.tools.logging."
   [writer format-in & args]
  (let [args2  (into [writer format-in] args)]
    (->> (apply cl-format args2) (wrnlog-info-log)  )  )  )


;;;;;;;;;
(def println-info    println-wrnlog-info-log)
(def cl-format-info    cl-format-wrnlog-info-log)
;;;;;;;;;;;;;;;;;;;




(defn gizmo-counter-with-result-out [n] (do (println "Hey! ") (cl-format true "my-ctlogging-lib.core/gizmo-counter-out: ~@(~R~) gizmo~:P counted.\n" n) n))
;; We want to change the program so that current callers of gizmo-counter-with-result-out still get their results, but string output is sent
;; to a log file (as info) instead of stdout. We have 2 options.

;; Option 1: We leave gizmo-counter-with-result-out intact, and callers must use gizmo-counter-with-result-info instead.
(defn gizmo-counter-with-result-info "return the result, log the output string as info."
   [n] (->> (gizmo-counter-with-result-out n) (wrnlog-info-log)    ))

;; Option 2: We modify the definition of gizmo-counter-with-result-out. In actual code we wouldn't add the "-MODIFIED" part. Callers don't have to be modified.
;; This example is for a function that uses cl-format. For other, similar utility functions, we would have to define their "wrnlog-info-log" version in a similar way.
(defn gizmo-counter-with-result-out-MODIFIED 
   [n] (do (println-info "Hey! ")(cl-format-info true "my-ctlogging-lib.core/gizmo-counter-out-MODIFIED: ~@(~R~) gizmo~:P counted.\n" n) n))
;;; Notice: option 1 will appear in the log file as a single log entry with a newline, while option 2 will appear as two consecutive log entries.






;; https://github.com/clojure/tools.logging
(defn divide [x y]
  (log/info "dividing" x "by" y)
  (try
    (log/spyf "result: %s" (/ x y)) ; yields the result
    (catch Exception ex
      (log/error ex "There was an error in calculation"))))




(defn foo
  "I don't do a whole lot."
  [x]
  (do 
  (println x "Hello, World!")
  
  
  ))
