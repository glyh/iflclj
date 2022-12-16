(ns iflclj.preclude
  (:require [clojure.string :as string]))

(def std
  (->>
    '((defn I [x] x)
      (defn K [x y] x)
      (defn K1 [x y] y)
      (defn S [f g x] (f x (g x)))
      (defn compose [f g x] (f (g x)))
      (defn twice [f] (compose f f)))
    (map prn-str)
    string/join))
