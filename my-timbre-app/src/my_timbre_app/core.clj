(ns my-timbre-app.core
  (:require
    [taoensso.timbre :as timbre   :refer [log  trace  debug  info  warn  error  fatal  report logf tracef debugf infof warnf errorf fatalf reportf  spy get-env]]
    [taoensso.timbre.appenders.core :as appenders]
    
    
    [my-timbre-lib.core :as mtl]
    [my-ctlogging-lib.core :as mctll]
    
    
    )
  (:gen-class))


;; https://github.com/ptaoussanis/timbre





;; add logging to a file.
;(timbre/merge-config!
  ;{:appenders {:spit (appenders/spit-appender {:fname "my-file.log"})}})


;; only log to a file, disable console output.
;; https://github.com/ptaoussanis/timbre/issues/213

(def log-fname "my-log-file.log")

(timbre/merge-config!
  {:appenders {:spit (appenders/spit-appender {:fname log-fname})
               :println {:enabled? false}}})


(defn clean-log "wipe the log file clean" [] (spit log-fname "") )

(defn my-mult [x y] (info "Lexical env:" (get-env)) (* x y))


(defn -main
  "Some tests for Timbre logging"
  [& args]
  
  (do
  
  (info "This will print")
  (spy :info (* 5 4 3 2 1))
  (my-mult 4 7)
  (trace "This won't print due to insufficient log level") 
  
  ; how do I get rid of annoying Esc characters?
  ;(info (Exception. "Oh noes") "arg1" "arg2")
  
  
  (mtl/divide 1 2)
  
  ;; this will print out
  (mtl/gizmo-counter-out 4)
  
  ;; this will write to log file.
  (mtl/gizmo-counter-log 5)
  
  
    )
  
 
  
  
  
  
  
  )



