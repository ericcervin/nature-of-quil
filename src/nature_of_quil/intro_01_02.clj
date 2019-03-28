(ns nature-of-quil.intro_01_02
  (:require [quil.core :as q]
            [quil.middleware :as m]))



(defn setup []  
  {:random-counts [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]})  
 
(defn update-state [state]
  (let [rc (:random-counts state)
        indx (rand-int (count rc))]
      {:random-counts (update rc indx inc)}))      
  
                                
(defn draw [state]
  (q/background 255)
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 127)
  (let [rc (:random-counts state)
        w (/ (q/width) (count rc))]
       (doseq [i (range (count rc))]
         (q/rect (* i w) 
                 (- (q/height) (rc i))
                 (- w 1)
                 (rc i)))))
           
           
  ;;(println (:random-counts state)))
    
(q/defsketch practice
  :size [640 430]
  :setup setup
  :update update-state
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])


