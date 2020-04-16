(ns conflux-portal-website.pages.home
  (:require
   [re-frame.core :as rf]
   [conflux-portal-website.subs :as subs]
   [breaking-point.core :as bp]))

(defn ui []
  (let [name (rf/subscribe [::subs/name])]
    [:div
     [:h1 (str "Hello from " @name ". This is the Home Page.")]
     [:div
      [:a {:href "#/about"}
       "go to About Page"]]
     [:div
      [:h3 (str "screen-width: " @(rf/subscribe [::bp/screen-width]))]
      [:h3 (str "screen: " @(rf/subscribe [::bp/screen]))]]
     ]))