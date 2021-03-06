(ns nature-of-quil.chap_01_ex_04
  (:require [quil.core :as q]))




(defn setup [])  
     

(defn draw []
  (let [mouse [(q/mouse-x) (q/mouse-y)]
        center [(/ (q/width) 2) (/ (q/height) 2)]
        mouse (map #(- %1 %2) mouse center)
        mouse (map #(* % 0.5) mouse)]
    
    (q/background 255)
    (q/translate (first center) (second center))
    (q/line 0 0 (first mouse) (second mouse))))
    
      
(q/defsketch practice
  :size [640 360]
  :setup setup
  :draw draw
  :features [:keep-on-top])



