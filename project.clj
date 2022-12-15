(defproject iflclj "0.1.0-SNAPSHOT"
  :description "Implementation of \"Core\" language from the book \"Implementation of Functional Languages\" by Simon L. P. Jones & David R. Lester "
  :url "https://github.com/glyh/iflclj"
  :license {:name "MIT License"
            :url "https://choosealicense.com/licenses/mit/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/core.match "1.0.0"]]
  :repl-options {:init-ns iflclj.core}
  :resource-paths ["resources/"])
