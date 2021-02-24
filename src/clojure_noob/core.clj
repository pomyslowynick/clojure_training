(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!" args))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})


(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))
(identity 1)
(defn hello_word_n_times [n] (loop [x n]                    ;; this works just like a 'let' binding.
                               (println "Hello World ")
                               (if (not= x 1)               ;; this is the base case.
                                 (recur (- x 1)))))

(defn print_n_times [n char] (map println (repeat n char)))

(defn list_replication [num lst] (map print_n_times (repeat num) lst))


(hello_word_n_times 2)

(defn multi-arity
  ;; 3-arity arguments and body
  ([first-arg second-arg third-arg]
   (println first-arg second-arg third-arg))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
   (println first-arg second-arg))
  ;; 1-arity arguments and body
  ([first-arg]
   (println first-arg)))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))
(def arrayMaster [])

(defn test_man
  [someArray]
  (my-reduce
    (fn [accum el]
      (into accum (set el)))
    []
    someArray))


(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))
(def mapperXd (hash-map :keykeky "sdaas" :meow "cat" :meow :meow))

(defn adder100
  [num]
  (+ num 100))

(defn dec-maker
  [num]
  #(- % num))

