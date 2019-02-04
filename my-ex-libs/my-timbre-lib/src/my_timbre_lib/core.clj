(ns my-timbre-lib.core

(:require     ;[clojure.tools.logging :as ctlog]
              [taoensso.timbre :as timbre   :refer [log  trace  debug  info  warn  error  fatal  report logf tracef debugf infof warnf errorf fatalf reportf  spy get-env]]
              [taoensso.timbre.appenders.core :as appenders]
              
              ;;For this demo:
              [clojure.pprint :as pp :refer [cl-format]]
              
              ))




;; https://github.com/clojure/tools.logging
(defn divide [x y]
  (timbre/info "dividing" x "by" y)
  (try
    (timbre/spy :info "divide-function" (/ x y)) ; yields the result
    (catch Exception ex
      (timbre/error ex "There was an error in calculation"))))



(defn cl-format-info [writer format-in & args]
  (let [args2  (into [writer format-in] args)]
    (->> (apply cl-format args2) (with-out-str) (timbre/info) )  )  )



(defn gizmo-counter-out [n] (cl-format true "~@(~R~) gizmo~:P counted.\n" n))

(defn gizmo-counter-log [n] (->> n (gizmo-counter-out) (with-out-str) (timbre/info)   ))

(defn gizmo-counter-info [n] (cl-format-info true "~@(~R~) gizmo~:P counted.\n" n))


(defn foo
  "I don't do a whole lot."
  [x]
  (do 
  (println x "Hello, World!")
  
  
  ))
