(defproject my-ctlogging-lib "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                  [org.clojure/tools.logging "0.4.1"]
  ]
  
  
  
  :local-repo  "../../my-timbre-app/local-m2"
  
  :dev [
        [org.clojure/tools.namespace "0.2.4"]
        
        
        ]
  
  
  
  :repl-options {:init-ns my-ctlogging-lib.core})
