(ns iflclj.parse
    (:require [malli.core :as m]
              [clojure.edn :as edn]))

(def ifl-schema
  [:schema
   {:registry
    {::defn
     [:catn [:_ [:= 'defn]]
            [:name :symbol]
            [:binds [:vector :symbol]] [:exp [:schema [:ref ::exp]]]]
     ::let
     [:catn [:lettype [:or [:= 'let] [:= 'letrec]]]
            [:bindings [:and [:vector :any]
                             [:* [:cat :symbol [:schema [:ref ::exp]]]]]]
            [:exp [:schema [:ref ::exp]]]]
     ::case
     [:catn [:_ [:= 'case]]
            [:exp [:schema [:ref ::exp]]]
            [:alts [:+ [:catn
                        [:lhs [:and [:vector :any]
                                    [:cat :int [:* :symbol]]]]
                        [:rhs [:schema [:ref ::exp]]]]]]]
     ::fn
     [:catn [:_ [:= 'fn]]
            [:binds [:vector :symbol]]
            [:exp [:schema [:ref ::exp]]]]
     ::call
     [:catn [:fn [:schema [:ref ::exp]]]
            [:args [:* [:schema [:ref ::exp]]]]]
     ::exp
     [:orn [:defn [:ref ::defn]]
           [:let [:ref ::let]]
           [:case [:ref ::case]]
           [:fn [:ref ::fn]]
           [:pack [:catn [:_ [:= 'pack]]
                         [:enum :int]
                         [:id :int]]]
           [:call [:ref ::call]]
           [:sym :symbol]
           [:int :int]]


     ::defns
     [:sequential [:ref ::defn]]}}
   ::defns])

(def ifl-parser (m/parser ifl-schema))
(defn syntax [input]
  (println input)
  (ifl-parser (edn/read-string (str "[" input "]"))))
