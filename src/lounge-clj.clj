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

(component comp1 [a b c] :a a :b b :c c)

(comp1 "argA" "argB" "argC")

(entity ent1 (comp1 "argA" "argB" "argC"))

(system sys1 identity)

(def env (atom []))

(reset! env (conj @env (ent1)))

(sys1 env)
