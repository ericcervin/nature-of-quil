(ns nature-of-quil.intro_01_04.clj
  (:require [quil.core :as q]))
      


(defn setup []
  (q/background 255))
  
 
                                
(defn draw []
  (q/fill 0 10)
  (q/no-stroke)
  (let [xloc (q/random-gaussian)
        sd 60
        mean (/ (q/width) 2)
        xloc (+ (* xloc sd) mean)]
    (q/ellipse xloc (/ (q/height) 2) 16 16)))
          
    
(q/defsketch practice
  :size [640 360]
  :setup setup
  :draw draw
  :features [:keep-on-top])



