(ns lounge-clj)

(defmacro component [name params & r]
  `(defn ~name ~params
     (hash-map :name ~(str name) ~@r)))

(defmacro entity [name & comps]
  `(defn ~name []
     [~(keyword name) ~(into [] comps)]))

(defmacro system [name func]
  `(defn ~name [env#]
     (reset! env# (~func @env#))
     env#))
