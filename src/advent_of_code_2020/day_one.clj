(ns advent-of-code-2020.day-one
  (:require [clojure.string :as str]))

;--- Day 1: Report Repair ---
;
;
;Before you leave, the Elves in accounting just need you to fix your expense report
; (your puzzle input); apparently, something isn't quite adding up.
;
;Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
;
;For example, suppose your expense report contained the following:
;
;1721
;979
;366
;299
;675
;1456
;
; In this list, the two entries that sum to 2020 are 1721 and 299.
; Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
;
; Of course, your expense report is much larger.
; Find the two entries that sum to 2020; what do you get if you multiply them together?



(defn read-lines
  [filename]
  (map #(Integer/parseInt %)
       (str/split (slurp filename)
                  (re-pattern "\r\n"))
       ))

(defn first-two-entries
  [filename]
  (first
    (for [x (read-lines filename)
          y (read-lines filename)
          :when (= 2020 (+ x y))]
      (* x y)
      )
    )
  )


;--- Part Two ---
;The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation.
; They offer you a second one if you can find three numbers in your expense report that meet the same criteria.
;Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
; Multiplying them together produces the answer, 241861950.
;In your expense report, what is the product of the three entries that sum to 2020?

(defn first-three-entries
        [filename]
        (first
          (for [x (read-lines filename)
                y (read-lines filename)
                z (read-lines filename)
                :when (= 2020 (+ x y z))]
            (* x y z)
            )
          )
        )

(time (first-two-entries "resources/day-one.txt"))
(time (first-three-entries "resources/day-one.txt"))


