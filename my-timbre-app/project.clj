(defproject my-timbre-app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.taoensso/timbre "4.10.0"]
                 
                 [my-timbre-lib/my-timbre-lib "0.1.0-SNAPSHOT"]
                 
                 ]
  
  :repositories [
      ["local" {:url ~(str (.toURI (java.io.File. "local-m2"))) :checksum :warn }  ]]
  
  
  
  
  :main ^:skip-aot my-timbre-app.core
  :target-path "target/%s"
  
  
  
  :profiles {:dev {:source-paths ["dev" "src" "test"]
                     :dependencies [ ;[org.clojure/tools.namespace "0.2.11"]
                                     [org.clojure/tools.namespace "0.2.4"]       ]}
             :uberjar {:aot :all}   }
  
  
  
  
  )


