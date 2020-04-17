(ns conflux-portal-website.pages.home
  (:require
   [re-frame.core :as rf]
   [conflux-portal-website.subs :as subs]
   [breaking-point.core :as bp]))

;; ----------------------------------------
;; | +-------------+                      |
;; | | logo        |              header  |
;; | +-------------+                      |
;; | ------------------------------------ |
;; |                                main  |
;; | +-------------+     +-------------+  |
;; | | +-------+   |     |             |  |
;; | | | des   |   |     | screenshot  |  |
;; | | +-------+   |     |             |  |
;; | | +-------+   |     |             |  |
;; | | | btn   |   |     |             |  |
;; | | +-------+   |     |             |  |
;; | |             |     |             |  |
;; | | left        |     | right       |  |
;; | +-------------+     +-------------+  |
;; |                                      |
;; | ------------------------------------ |
;; |                              footer  |
;; |                                      |
;; ----------------------------------------

;;; background
(defn background-circle-2 []
  [:div.circle-2])

;;; header
(defn logo []
  [:img.portal-logo {:src "images/portal_logo.svg"}])

(defn header [] [:header.home-header [logo]])

;;; main
;; left
;; des
(defn new-arrival []
  [:div.new-arrival.flex-center.b.ttu "new arrival"])

(defn portal-title []
  [:span.nowrap.portal-title.b.ttc "conflux portal"])

(defn portal-des []
  [:p.portal-des-text "ConfluxPortal is an extension for accessing Conflux enabled distributed applications, or \"DApps\" in your normal browser!"])

(defn main-des-container []
  [:section.flex-column.des-container [new-arrival] [portal-title] [portal-des]])

;; btn
(defn download-btn []
  [:div.download.flex-center
   [:div.wrapper.flex-center
    [:span.b "Download"]
    [:img {:src "images/download_icon.svg"}]]])

(defn installation-btn []
  [:div.installation
   [:span.b "Installation Guidance"]
   [:img {:src "images/guidance_icon.svg"}]
   [:div.underline]])

(defn main-btn-container []
  [:section.btns [download-btn] [installation-btn]])

(defn main-left []
  [:section.main-left [main-des-container] [main-btn-container]])

;; right
;; screenshot

(defn portal-screenshot []
  [:img.portal-screenshot {:src "images/portal-demo.png"}])

(defn background-circle-1 []
  [:img.circle-1 {:src "images/circles_pattern.svg"}])

(defn main-right []
  [:section.main-right.flex-center [portal-screenshot] [background-circle-2] [background-circle-1]])

(defn main []
  [:section.main.flex-center [main-left] [main-right]])

;;; footer
(defn footer []
  [:footer
   [:div.wrapper.flex-row
    [:section.flex-column
     [:span.ttu.b "need help?"]
     [:a.mailto {:href "mailto:portal@conflux-chain.org"} "portal@conflux-chain.org"]]
    [:section.flex-column
     [:span.ttu.b "learn more"]
     [:a {:href "https://conflux-chain.github.io/conflux-portal-docs/"} "documentation"]
     [:a {:href "https://confluxnetwork.org"} "conflux network"]
     [:a {:href "https://confluxnetwork.org/policy/"} "privacy policy"]
     [:a {:href "https://confluxnetwork.org/terms/"} "term of services"]]
    [:section.flex-column
     [:span.ttu.b "get involved"]
     [:a {:href "https://github.com/Conflux-Chain/conflux-portal"} "GitHub"]
     [:a {:href "https://github.com/Conflux-Chain/conflux-portal"} "bounty program"]]
    [:section.flex-column
     [:span.ttu.b "connect"]
     [:a {:href "mailto:portal@conflux-chain.org"} "contact us"]
     [:a {:href "https://github.com/Conflux-Chain/conflux-portal/issues/new/choose"} "support"]
     [:a {:href "https://twitter.com/@Conflux_Network"} "twitter"]]]
   [:div.copy-right [:span "Copyright©2020 Conflux. All Rights Reserved."]]])

;;; page
(defn ui []
  [:div.container [:div.header-and-main [header] [main]] [footer]])