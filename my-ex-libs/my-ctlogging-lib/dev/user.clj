(ns user
  (:require [clojure.tools.namespace.repl :as tnr]))

(def testing "this is a test")

(defn refresh [] (tnr/refresh))
; usage in "lein repl": my-timbre-lib.core=> (user/refresh)
