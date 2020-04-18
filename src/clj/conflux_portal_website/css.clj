(ns conflux-portal-website.css
  (:require [garden.def :refer [defstyles]]
            [garden.core :refer [css]]
            [garden.stylesheet :refer [at-media at-keyframes]]))

(defstyles screen
;;; global
  [:* {:box-sizing "border-box"}]
  [:.overflow-hidden {:overflow "hidden"}]
  [:.nowrap {:white-space "nowrap"}]
  [:.flex-column {:display "flex" :flex-direction "column"}]
  [:.flex-center {:display "flex" :justify-content "center" :align-items "center"}]
  [:.flex-row {:display "flex" :flex-direction "row"}]
  [:.b {:font-weight "bold"}]
  [:.ttu {:text-transform "uppercase"}]
  [:.ttc {:text-transform "capitalize"}]
  [:.ttl {:text-transform "lowercase"}]
  [:body {:font-family "ProximaNova-Bold,ProximaNova" :width "100%"}]
  [:#app {:width "100%"}]
  ;; home page
  [:.container
   {:width "100%"
    :background "linear-gradient(137deg,rgba(80,93,116,1) 0%,rgba(42,48,74,1) 100%)"
    :background-size "auto 80%"
    :min-width "68rem"}

   [:.header-and-main {:width "100%" :overflow "hidden"}
    ;; header
    [:header
     {:padding "3.19rem 0"}
     [:.portal-logo {:width "26.19rem" :margin-left "6.25rem"}]]
    ;; main
    ;; (at-media
    ;;   {:max-width "68rem"}
    ;;   [:.main {:flex-direction "column"}])
    [:.main
     {:display "flex"
      :padding "1.06rem 11.56rem 6.88rem 11.56rem"
      :justify-content "center"
      :margin "auto"
      :flex-direction "row"}

     ;; left
     [:.main-left
      {:padding-right "19.56rem"}
      [:.des-container {:padding-bottom "10.91rem"}
       [:.new-arrival {:background "rgba(0,0,0,0.1)"
                       :border-radius "1.22rem"
                       :width "9.5rem"
                       :color "rgba(72,144,204,1)"
                       :line-height "1.19rem"
                       :margin-top "0.03rem"
                       :margin-bottom "1.53rem"
                       :padding "0.65rem 1.19rem"
                       :text-align "center"}]
       [:.portal-title {:font-size "2.63rem"
                        :color "white"
                        :line-height "3.54rem"
                        :padding-bottom "1.22rem"}]
       [:.portal-des-text {:font-weight "400"
                           :max-width "25rem"
                           :color "rgba(251,251,255,1)"
                           :line-height "2rem"}]]
      [:.btns
       [:.download
        {:cursor "pointer"
         :margin-bottom "1.5rem"
         :background "linear-gradient(270deg,rgba(126,161,13,1) 0%,rgba(194,195,6,1) 46%,rgba(252,223,0,1) 100%)"
         :box-shadow "0rem 0rem 0.38rem 0rem rgba(151,174,8,1)"
         :border-radius "1.53rem"
         :width "10.56rem"
         :height "3.06rem"}
        [:.wrapper
         {:align-items "flex-end"}
         [:span {:line-height "1.19rem" :margin-right "1rem" :color "white"}]
         [:img {:width "1.31rem" :height "1.31rem"}]]]
       [:.installation
        {:cursor "pointer"}
        [:span {:background "linear-gradient(270deg, rgba(143,170,11,1) 0%, rgba(244,219,1,1) 100%)"
                :line-height "1.53rem"
                :color "rgba(243,219,1,1)"
                :-webkit-background-clip "text"
                :-webkit-text-fill-color "transparent"
                :margin-right "0.5rem"}]
        [:img {:width "1rem" :height "0.8rem"}]
        [:div.underline {:width "12.31rem"
                         :height "0.13rem"
                         :background "linear-gradient(270deg,#86A50C 0%,rgba(194,195,6,1) 46%,rgba(252,223,0,1) 100%)"}]]]]
     ;; right
     [:.main-right
      {:display "flex" :justify-content "flex-end" :position "relative"}
      [:.portal-screenshot {:z-index 2}]
      [:.circle-1 {:position "absolute"
                   :margin-left "-10.38rem"
                   :z-index 1
                   :width "25.75rem"}]
      [:.circle-2 {:z-index 1
                   :top "-23rem"
                   :left "-2.63rem"
                   :position "absolute"
                   :border-radius "50%"
                   :width "60rem"
                   :height "60rem"
                   :background "linear-gradient(227deg,rgba(55,64,89,1) 0%,rgba(78,91,114,1) 100%)"}]]]]
   ;; footer
   [:footer
    {:background "white" :padding "3.94rem 3rem"}
    [:.wrapper
     {:position "relative"
      :max-width "64rem"
      :min-width "40rem"
      :margin "auto"
      :justify-content "space-between"}
     [:section
      [:.mailto {:text-transform "lowercase"}]
      [:span {:color "rgba(1,7,63,1)"
              :line-height "0.88rem"
              :font-size "1.25rem"
              :margin-bottom "2rem"}]
      [:a {:text-transform "capitalize"
           :font-weight "400"
           :color "#6D6D6D"
           :line-height "2.5rem"
           :text-decoration "none"}]
      [:a:hover {:color "#2196f3"}]]]
    [:.copy-right {:margin "5rem auto 0"
                   :width "100%"
                   :text-align "center"
                   :font-weight 400
                   :color "#6D6D6D"}]]]
  ;;; components
  (at-keyframes
   :dots
   [:0% :20% {:color "rgba(0,0,0,0)" :text-shadow ".25em 0 0 rgba(0,0,0,0), 5em 0 0 rgba(0,0,0,0)"}]
   [:40% {:color "white" :text-shadow ".25em 0 0 rgba(0,0,0,0), 5em 0 0 rgba(0,0,0,0)"}]
   [:60% {:text-shadow ".25em 0 0 white, .5em 0 0 rgba(0,0,0,0)"}]
   [:80% :100% {:color "white" :text-shadow ".25em 0 0 white, .5em 0 0 white"}])
  [:.loading-dots:after
   {:content "\" .\""
    :animation "dots 1s steps(5,end) infinite"}])