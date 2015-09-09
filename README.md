# lounge-clj
======
Clojure CES Engine

lounge-clj is a project to create a Component Entity System in as few lines of code (LOC) as possible.

```clojure
;; add dependencies
(set-env! :dependencies '[[adzerk/boot-reload "0.1.0"]])

;; require in namespace
(:require [lounge-clj :as lounge])
```

## Component, Entity, System
======

###Components
Components are small independant reusable bit's of state which can be attached to Entities.
These bit's of state are implemented as hash-maps.

###Entity
Entities consist of a universally unique name associated to a collection of Components.
Entities are implemented as a vector containing:
   a) a UUID
   b) Vector of Components

###System
Systems are small independant functions which act upon the global environment of Entities,
and optionally mutate state.

## Example
======

There are three (3) main macro's in lounge-clj each returns a new function.

```clojure
(def env (atom [])) #'lounge-clj/env

(component comp1 [a b c] :a a :b b :c c) #'lounge-clj/comp1

(comp1 "argA" "argB" "argC") #{:a "argA", :name "comp1", :c "argC", :b "argB"}

(entity ent1 (comp1 "argA" "argB" "argC")) #'lounge-clj/ent1

(system sys1 identity) #'lounge-clj/sys1

(reset! env (conj @env (ent1)))

(-> env
  sys1)

```

