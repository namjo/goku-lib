(ns dhjn.tools-test
  (:require [clojure.test :refer :all]
            [dhjn.tools :refer :all]))

(def x-map (hash-map :a 0 :b 1 :c "foo"))
(def x-keys [:a :c])

(deftest select-values-test
  (testing "test select values"
    (is (= (select-values x-map x-keys) '(0 "foo")))))

(deftest surround-test
  (testing "surround"
    (is (= (surround "hallo" "\"") "\"hallo\"")))
  (testing "surround-fn"
    (def parametized-surround (surround-fn " ' "))
    (is (= (parametized-surround "hallo") " ' hallo ' "))))

(deftest select-comma-list-test
  (testing "comma-list"
    (is (= (select-comma-list x-map x-keys) "\"0\", \"foo\""))))

(deftest bracket-test
  (testing "surround string with matching brackets"
    (is (= (bracket "hallo" ")") "(hallo)"))
    (is (= (bracket "hallo" "(") "(hallo)"))
    (is (= (bracket "hallo" "[") "[hallo]"))
    (is (= (bracket "hallo" "]") "[hallo]"))
    (is (= (bracket "hallo" "}") "{hallo}"))
    (is (= (bracket "hallo" "{") "{hallo}"))
    (is (= (bracket "hallo" "<") "<hallo>"))
    (is (= (bracket "hallo" ">") "<hallo>"))
    ))


