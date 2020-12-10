(ns advent-of-code-2020.day-four
  (:require [clojure.string :as str]))

; Count the number of valid passports
; those that have all required fields.
; Treat cid as optional.
; In your batch file, how many passports are valid?

(defn read-lines
  [filename]
  (map #(str %)
       (str/split (slurp filename)
                  (re-pattern "\r\n\r\n"))
       ))

(defn clean-file-input
  [filename]
  (map #(str/replace % "\r\n" " ") (read-lines filename)))

(def optional-passport-keys "cid")
(def passport-keys ["byr" "iyr" "eyr" "hgt" "hcl" "ecl" "pid"])

(def regex #"(?:byr|iyr|eyr|hgt|hcl|ecl|pid)\:[a-z0-9|#]*")

(defn check [line]
  (= (count (#(re-seq regex %) line)) (count passport-keys)))

(defn get-valid-passports
  [filename]
  (count (filter check (clean-file-input filename)))
  )

(time (get-valid-passports "resources/day-four.txt"))