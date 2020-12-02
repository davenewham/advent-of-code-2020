(ns advent-of-code-2020.day-one-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2020.day-one :refer :all]))


(deftest file-input-test
  (testing "If file's are read in correctly as a vector of integers"
    (is (= (1721 979 366 299 675 1456) (read-lines "resources/day-one-test.txt")))
    )
  )

(deftest check-task-one
  (testing "If matches given answer"
    (is (= 514579 (first-two-entries "resources/day-one-test.txt")))))

(deftest check-task-two
  (testing "If matches given answer"
    (is (= 241861950 (first-three-entries "resources/day-one-test.txt")))))

