(ns dhjn.tools)

; (def brackets '(:round "()" :square "[]" :curly "{}" :angle "<>"))
(def brackets ["()" "[]" "{}" "<>"])

(defn select-values [x-map x-keys] (vals (select-keys x-map x-keys)))
(defn surround-fn [delimiter] (fn [string] (str delimiter string delimiter)))
(defn surround [string delimiter] (str delimiter string delimiter))

(defn select-comma-list [x-map x-keys]
  (clojure.string/join
   ", "
   (map
     (surround-fn "\"")
     (select-values x-map x-keys))))

(defn foo-fn 
  [brackettype] 
  (fn 
    [accstring b] 
    (let [f (str (first b)) l (str (last b))]
      (if (or (= f brackettype) (= l brackettype))
        (str f accstring l)
        accstring))))

(defn bracket [string brackettype] (reduce (foo-fn brackettype) string brackets))
