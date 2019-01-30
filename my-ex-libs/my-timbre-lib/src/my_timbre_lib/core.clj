(ns my-timbre-lib.core

(:require     ;[clojure.tools.logging :as ctlog]
              [taoensso.timbre :as timbre   :refer [log  trace  debug  info  warn  error  fatal  report logf tracef debugf infof warnf errorf fatalf reportf  spy get-env]]
              [taoensso.timbre.appenders.core :as appenders]



))


;; https://github.com/clojure/tools.logging
(defn divide [x y]
  (timbre/info "dividing" x "by" y)
  (try
    (timbre/spy :info "divide-function" (/ x y)) ; yields the result
    (catch Exception ex
      (timbre/error ex "There was an error in calculation"))))




(defn foo
  "I don't do a whole lot."
  [x]
  (do 
  (println x "Hello, World!")
  
  
  ))
