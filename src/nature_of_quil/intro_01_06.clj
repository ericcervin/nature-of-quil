(ns nature-of-quil.intro_01_06
  (:require [quil.core :as q]))

(defn setup []
  (q/no-loop))

                                
(defn draw []
  (q/background 0) 
  (let [im (q/create-image 640 360 :rgb)
        increment 0.02]
    (dotimes [x 640]
      (dotimes [y 360] 
        (let [xoff (* x increment)
              yoff (* y increment)
              bright (* (q/noise xoff yoff) 255)]
  
           (q/set-pixel im x y (q/color bright)))))
  
   (q/image im 0 0)))
    
    
     
    
(q/defsketch practice
  :size [640 360]
  :setup setup
  :draw draw
  :features [:keep-on-top])



