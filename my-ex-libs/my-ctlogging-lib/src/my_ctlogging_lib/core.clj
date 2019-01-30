(ns my-ctlogging-lib.core

(:require [clojure.tools.logging :as log]))


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
