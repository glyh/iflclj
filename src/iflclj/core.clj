(ns iflclj.core
    (:require [clj-antlr.core :as antlr]
              [clojure.java.io :as io]))

; I don't give a fuck to the frontend, as a lisper
(defn syntax [form]
  ())

(def parse (comp read-string syntax))
   
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

