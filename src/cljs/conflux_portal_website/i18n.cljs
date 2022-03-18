(ns conflux-portal-website.i18n
  (:require
   [tongue.core :as tongue]
   [clojure.string :as s]))

(def dicts
  {:en
   {:home-page/description "ConfluxPortal is an extension to access Conflux Network Ecosystem DApps from your preferred browser. Available now: Google Chrome, Firefox, QQBrowser, 360Browser, SogouBrowser."
    :word/install          "install"
    :word/learn-more       "Learn More"
    :home-page/warning     "ConfluxPortal has stopped updating and no new versions will be released. Fluent wallet is recommended."}
   :zh-CN
   {:home-page/description "ConfluxPortal 是一个浏览器扩展程序，可以用于 Conflux 网络中的各种去中心化应用。目前支持的浏览器包括：谷歌浏览器、火狐浏览器、QQ浏览器、360浏览器、搜狗浏览器。"
    :word/install          "安装"
    :word/learn-more       "了解更多"
    :home-page/warning     "ConfluxPortal 已停止升级计划，不再会有新版本发布。推荐使用全新的 Fluent 钱包"}
   :tongue/fallback :en})

(def translate (tongue/build-translate dicts))

(defn navlang->langkey []
  (let [navlang js/window.navigator.language]
    (if (s/starts-with? navlang "zh")
      :zh-CN
      :en)))

(defn t
  ([transkey]
   (translate (navlang->langkey) transkey))
  ([langkey transkey]
   (translate langkey transkey)))
