(set-env!
  :dependencies  '[[adzerk/bootlaces    "0.1.12"]
                   [org.clojure/clojure "1.7.0"]]
  :source-paths   #{"src"})

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.1.0")

(bootlaces! +version+)

(task-options!
  pom {:project 'degree9/lounge-clj
       :version +version+
       :description "Clojure Component Entity System"
       :url         "https://github.com/degree9/lounge-clj"
       :scm         {:url "https://github.com/degree9/lounge-clj"}})
