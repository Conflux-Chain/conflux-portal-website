(ns conflux-portal-website.components.get-portal-url
  (:require
   [goog.labs.userAgent.browser :refer [isChrome isFirefox]]
   [goog.labs.userAgent.device :refer [isMobile]]
   [re-frame.core :as rf]))

(defn can-visit-google-webstore? []
  (let [f (js/fetch "https://chrome.google.com/webstore" #js {:mode "cors"})]
    (.then
     (js/Promise. (fn [resolve]
                    (js/setTimeout #(resolve false) 3000)
                    (.then f #(resolve true))
                    (.catch f #(resolve true))))
     (fn [store?]
       (rf/dispatch [::store? store?])
       store?))))

(defn get-download-url []
  (.then (can-visit-google-webstore?)
         (fn [store?]
           (cond
             (isMobile)                                                "https://github.com/Conflux-Chain/conflux-portal/releases/tag/v0.6.9"
             (and (isChrome) (.includes js/navigator.userAgent "Edg")) "https://microsoftedge.microsoft.com/addons/detail/confluxportal/lgegkgjpjkcbhblfidojklhahcbafhno"
             (and (not store?) (isChrome))                             "https://conflux-soft.oss-cn-beijing.aliyuncs.com/portal/conflux-portal-chrome-0.6.9.zip"
             (isChrome)                                                "https://github.com/Conflux-Chain/conflux-portal/releases/download/v0.6.9/conflux-portal-chrome-0.6.9.zip"
             (isFirefox)                                               "https://addons.mozilla.org/firefox/addon/conflux-portal/"
             :else                                                     "https://github.com/Conflux-Chain/conflux-portal/releases/tag/v0.6.9"))))

(rf/reg-event-db
 ::store?
 (fn [db [_ store?]]
   (assoc db :can-visit-store? store?)))

(rf/reg-sub
 ::store?
 (fn [db _]
   (:can-visit-store? db)))