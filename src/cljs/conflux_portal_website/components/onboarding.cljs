(ns conflux-portal-website.components.onboarding
  (:require
   ["conflux-portal-onboarding/dist/conflux-portal-onboarding.cjs.js" :as Onboarding]
   [re-frame.core :as rf]))

;; debug onboarding package
(set! (.-FAKE_PORTAL_SITE js/window) true)
(def onboarding (Onboarding. (js-obj "cachedPortalVersion" "0.5.10" "ignoreSessionStorage" true)))

(defn portal-installed? []
  (Onboarding/isConfluxPortalInstalled))

(defn get-download-url []
  (.then (.getDownloadUrl onboarding) #(rf/dispatch [::portal-download-url %])))

(get-download-url)

(rf/reg-event-db
 ::portal-download-url
 (fn [db [_ url]]
   (if url
     (assoc db :portal-download-url url)
     db)))

(rf/reg-sub
 ::portal-download-url
 (fn [db _]
   (:portal-download-url db)))