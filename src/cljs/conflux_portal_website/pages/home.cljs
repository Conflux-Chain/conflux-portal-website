(ns conflux-portal-website.pages.home
  (:require
   [clojure.string :as s]
   [goog.labs.userAgent.browser :refer [isSafari]]
   [re-frame.core :as rf]
   [conflux-portal-website.components.get-portal-url :as gpu]
   [conflux-portal-website.components.onboarding :as onboarding]
   [conflux-portal-website.i18n :as i18n]))

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
  [:span.nowrap.portal-title.b "ConfluxPortal"])

(defn portal-des []
  [:p.portal-des-text [i18n/t :home-page/description]])

(defn main-des-container []
  [:section.flex-column.des-container [new-arrival] [portal-title] ;; [portal-des]
   ])

;; btn
(defn download-btn [download-url]
  [:div.download.flex-center
   {:on-click (fn [] (and download-url (js/open download-url)))}
   [:div.wrapper.flex-center
    [:span.b
     {:class (and (not download-url) "loading-dots")} [i18n/t :word/learn-more]]
    (and download-url [:img {:src "images/right_arrow.svg"}])]])

(defn installation-btn []
  (let [store? @(rf/subscribe [::gpu/store?])]
    [:div.installation
     {:on-click #(js/open (if (or store? (isSafari))
                            "https://medium.com/@ConfluxNetwork/confluxportal-installation-and-user-manual-9f50de62fee0"
                            "https://juejin.im/post/5e9d8133e51d4546b90d2ee9"))}
     [:span.b (str "Installation Guidance ")]
     [:img {:src "images/guidance_icon.svg"}]
     [:div.underline]]))

(defn warning-container []
  [:div.warning-container
   [:img.bg {:src "images/notice-bg.svg"}]
   [:div.fg
    [:div.left-panel]
    [:div.right-panel
     [:p.warning [i18n/t :home-page/warning]]
     [download-btn "https://fluentwallet.com"]]]])

(defn main-btn-container []
  [:section.btns
   [warning-container]])

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
     [:a.mailto {:href "mailto:portal@confluxnetwork.org"} "portal@confluxnetwork.org"]]
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
     [:a {:href "mailto:portal@confluxnetwork.org"} "contact us"]
     [:a {:href "https://github.com/Conflux-Chain/conflux-portal/issues/new/choose"} "support"]
     [:a {:href "https://twitter.com/@Conflux_Network"} "twitter"]]]
   [:div.copy-right [:span "©2021 Conflux. All Rights Reserved."]]])

;;; page
(defn ui []
  [:div.container [:div.header-and-main [header] [main]] [footer]])
