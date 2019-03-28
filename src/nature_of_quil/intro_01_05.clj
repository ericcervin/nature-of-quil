(ns nature-of-quil.intro_01_05
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defrecord Walker [poss-x poss-y noff-x noff-y])


(defn walk [w]
  (merge w {:poss-x (q/map-range (q/noise (:noff-x w)) 0 1 0 (q/width))
            :poss-y (q/map-range (q/noise (:noff-y w)) 0 1 0 (q/height))
            :noff-x (+ (:noff-x w) 0.01)
            :noff-y (+ (:noff-y w) 0.01)}))


(defn display [w]
  (q/stroke-weight 2)
  (q/fill 127)
  (q/stroke 0)
  (q/ellipse (:poss-x w) (:poss-y w) 48 48))

(defn setup []
  (q/frame-rate 30)
  {:w (->Walker (/ (q/width) 2) (/ (q/height) 2) (rand 1000) (rand 1000))})  
 
(defn update-state [state]
  {:w (walk (:w state))})
                                
(defn draw [state]
  (q/background 255)
  (display (:w state)))
    
(q/defsketch practice
  :size [800 200]
  :setup setup
  :update update-state
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])


