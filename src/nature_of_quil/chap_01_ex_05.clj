(ns nature-of-quil.chap_01_ex_05
  (:require [quil.core :as q]
            [clojure.math.numeric-tower :as math]))




(defn setup [])  
     
(defn magnitude [x1 y1 x2 y2]
  (let [dx (- x2 x1)
        dy (- y2 y1)]
    (math/sqrt (+ (* dx dx) (* dy dy)))))
    

(defn draw []
  (let [mouse [(q/mouse-x) (q/mouse-y)]
        center [(/ (q/width) 2) (/ (q/height) 2)]
        mouse (map #(- %1 %2) mouse center)
        mag (magnitude 0 0 (first mouse) (second mouse))]
        
    
    (q/background 255)
    
    (q/fill 0)
    (q/rect 0 0 mag 10)
    
    (q/translate (first center) (second center))
    (q/line 0 0 (first mouse) (second mouse))))
    
    
    
      
(q/defsketch practice
  :size [640 360]
  :setup setup
  :draw draw
  :features [:keep-on-top])



