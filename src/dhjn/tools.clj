(ns dhjn.tools)

(defn select-values [x-map x-keys] (vals (select-keys x-map x-keys)))
(defn surround-fn [delimiter] (fn [string] (str delimiter string delimiter)))
(defn surround [string delimiter] (str delimiter string delimiter))

(defn select-comma-list [x-map x-keys]
  (clojure.string/join
   ", "
   (map
     (surround-fn "\"")
     (select-values x-map x-keys))))

