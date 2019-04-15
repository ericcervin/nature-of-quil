(ns nature-of-quil.chap_01_ex_07
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defrecord Mover [x y vx vy]) 


(defn setup []  
  (map->Mover {:x  (rand-int (q/width)) 
               :y  (rand-int (q/height)) 
               :vx (- (rand 4) 2)
               :vy (- (rand 4) 2)}))

(defn update-mover [m]
  (merge m {:x (+ (:x m) (:vx m))
            :y (+ (:y m) (:vy m))}))
            

(defn check-mover [m]
  (let [x (:x m)
        y (:y m)]
   (merge m {:x (cond 
                  (> x (q/width)) 0 
                  (< x  0       ) (q/width)
                  :else x)
             
             :y (cond 
                  (> y (q/height)) 0 
                  (< y  0        ) (q/height)
                  :else y)})))
                 
 
(defn update-state [m]
  (-> m update-mover check-mover))
                                
(defn draw [m]
  (q/background 255)
  (q/stroke 0)
  (q/fill 175)
  (q/ellipse (:x m) (:y m) 16 16))
      
(q/defsketch practice
  :size [800 200]
  :setup setup
  :update update-state
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
