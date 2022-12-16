(ns iflclj.core
  (:require [iflclj.preclude :as preclude]
            [iflclj.parse :as parse]))

(defn ifl-compile [src]
  ;; Directly inject std into source code, feels silly but is good enough right now
  (parse/syntax (str preclude/std src)))
(defn -main []
  (println (ifl-compile (slurp *in*))))
