(ns nature-of-quil.chap_01_ex_01
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []  
  {:x 100 :y 100 :xspeed 2.5 :yspeed 2})  
 
(defn update-state [state]
  (let [xs (:xspeed state)
        ys (:yspeed state)
        x (+ (:x state) xs)
        y (+ (:y state) ys)]
        
   {:x x
    :y y
    :xspeed (if (or (> x (q/width))  (< x 0)) (* -1 xs) xs)
    :yspeed (if (or (> y (q/height)) (< y 0)) (* -1 ys) ys)}))
                                
(defn draw [state]
  (q/background 255)
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 127)
  (q/ellipse (:x state) (:y state) 40 40))
      
(q/defsketch practice
  :size [800 200]
  :setup setup
  :update update-state
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])


