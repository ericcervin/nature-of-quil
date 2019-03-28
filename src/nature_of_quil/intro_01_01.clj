(ns nature-of-quil.intro_01_01
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defrecord Walker [x y])


(defn step-walker [w]
  (let [x (:x w)
        y (:y w)]
   (merge w (case (rand-int 4)
              0 {:x (q/constrain (inc x) 0 (- (q/width) 1))}
              1 {:x (q/constrain (dec x) 0 (- (q/width) 1))}
              2 {:y (q/constrain (inc y) 0 (- (q/height) 1))}
              3 {:y (q/constrain (dec y) 0 (- (q/height) 1))}))))

(defn render-walker [w]
  (q/stroke 0)
  (q/point (:x w) (:y w)))

(defn setup []
  (q/background 255)
  {:w (->Walker (/ (q/width) 2) (/ (q/height) 2))})  
 
(defn update-state [state]
  {:w (step-walker (:w state))})
                                
(defn draw [state]
  (render-walker (:w state)))
    
(q/defsketch practice
  :size [640 430]
  :setup setup
  :update update-state
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])


