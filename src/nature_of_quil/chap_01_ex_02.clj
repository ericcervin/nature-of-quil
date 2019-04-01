(ns nature-of-quil.chap_01_ex_02
  (:require [quil.core :as q]
            [quil.middleware :as m]))



(defn setup []  
  (q/background 255)
  {:position [100 100]
   :velocity [2.5 5]})  
 
(defn update-state [state]  
  (let [position (state :position)
        velocity (state :velocity)
        vx (first velocity)
        vy (second velocity)
        x (+ (first position) vx)
        y (+ (second position) vy)
        vx (if (or (> x (q/width)) (< x 0))
             (* vx -1)
             vx)
        vy (if (or (> y (q/height)) (< y 0))
             (* vy -1)
             vy)]
        
   {:position [x y]
    :velocity [vx vy]}))

(defn draw [state]
  (q/fill 255 10)
  (q/rect 0 0 (q/width) (q/height))
  (q/stroke 0)
  (q/fill 175)
  (q/ellipse (get-in state [:position 0]) (get-in state [:position 1]) 16 16))
      
(q/defsketch practice
  :size [200 200]
  :setup setup
  :update update-state
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])


