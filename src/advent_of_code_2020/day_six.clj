(ns advent-of-code-2020.day-six
  (:require [advent-of-code-2020.day-four :refer :all]
            [clojure.string :as str]))

(defn count-of-items
  [coll]
  (reduce + (map #(count %) coll))
  )

(def input-file (clean-file-input "resources/day-six.txt"))


(def clean (map #(str/replace % #" " "") input-file))
(def unique-items (map #(distinct %) clean))
(def count-1 (count-of-items unique-items))

(time (println count-1))

(clojure.set/intersection clean)
(def collect (map #(str/split % #" ") input-file))

; Could of also done a union for the first question
(def intersect (map #(reduce clojure.set/intersection (map set %)) collect))
(def count-2 (count-of-items intersect))

(time (println count-2))
