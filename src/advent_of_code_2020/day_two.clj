(ns advent-of-code-2020.day-two
  (:require [clojure.string :as str]))

(defn read-lines
  [filename]
  (map #(str %)
       (str/split (slurp filename)
                  (re-pattern "\r\n"))
       ))


(def line-match-regex #"^(\d+)-(\d+)\s([a-z]):\s([a-z]*)")

; Return all matches, except itself
(defn extract-information-from-line
  [line]
  (rest
    (re-matches line-match-regex line)
))


(defn return-count
  [x]
  (count (remove #(not= (first (char-array (nth x 2))) %) (nth x 3)))
  )

(defn min-value [split-line]
  (Integer/parseInt (nth split-line 0))
  )

(defn max-value [split-line]
  (Integer/parseInt (nth split-line 1))
  )

(defn count-char-value [x]
  (return-count x))

(defn get-truth [x]
  (if (and (<= (min-value x) (count-char-value x)) (>= (max-value x) (count-char-value x)))
    true
    false
    )
  )

(defn is-in-range
  [x]
  ;(println "min " (min-value x))
  ;(println "max " (max-value x))
  ;(println "count " (count-char-value x))
  ;(println "truthy" (get-truth x))
  (get-truth x)
  )



(defn task-one [file]
  (count (remove false? (map #(is-in-range (extract-information-from-line %)) (read-lines file))))
  )

(time (task-one "resources/day-two.txt"))

