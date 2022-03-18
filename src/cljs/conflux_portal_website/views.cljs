(ns conflux-portal-website.views
  (:require
   [re-frame.core :as rf]
   [conflux-portal-website.subs :as subs]
   [conflux-portal-website.pages.home :as home]))

;; about
(defn about-panel []
  [:div
   [:h1 "This is the About Page."]
   [:div
    [:a {:href "#/"}
     "go to Home Page"]]])

;; main
(defn- panels [panel-name]
  (case panel-name
    :home-panel [home/ui]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
