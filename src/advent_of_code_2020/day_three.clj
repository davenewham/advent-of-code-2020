(ns advent-of-code-2020.day-three
  (:require [clojure.string :as str]))

(defn read-lines
  [filename]
  (map #(str %)
(str/split (slurp filename)
           (re-pattern "\r\n"))
))

(def file-input (read-lines "resources/day-three.txt"))

(def height (count file-input))
(def width (count (first file-input)))

(defn get-from-coord
  [x y]
  (nth (nth file-input y) (mod x width))
  )

(defn get-trees [in-x in-y]
  (for [z (range 0 height)
        :let [x (* z in-x)
              y (* z in-y)
              tree (if (< y height) (get-from-coord x y) nil)]]
    (= \# tree)
    )
  )

(defn get-count-of-trees
  [[x y]]
(count (filter true? (get-trees x y)))
)

(time (reduce *(map get-count-of-trees [[3 1] [1 1] [5 1] [7 1] [1 2]])))