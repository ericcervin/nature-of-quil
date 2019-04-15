(ns nature-of-quil.chap_01_ex_06
  (:require [quil.core :as q]
            [clojure.math.numeric-tower :as math]))




(defn setup [])  
     

(defn normalize [x1 y1 x2 y2]
  (let [dx (- x2 x1)
        dy (- y2 y1)
        mag (math/sqrt (+ (* dx dx) (* dy dy)))]
       
       (if (= mag 0) [x1 y1 x2 y2]
                     [x1 y1 (+ x1 (/ dx mag)) (+ y1 (/ dy mag))])))
         
    
    

(defn draw []
  (let [mouse [(q/mouse-x) (q/mouse-y)]
        center [(/ (q/width) 2) (/ (q/height) 2)]
        mouse (map #(- %1 %2) mouse center)
        norm (normalize 0 0 (first mouse) (second mouse))
        norm (mapv #(* % 150) norm)]
    
    (q/background 255)
    
    (q/translate (first center) (second center))
    (q/line 0 0 (norm 2) (norm 3))))
    
    
    
      
(q/defsketch practice
  :size [640 360]
  :setup setup
  :draw draw
  :features [:keep-on-top])



