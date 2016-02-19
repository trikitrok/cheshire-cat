(ns cheshire-cat.core
  (:require-macros
    [cljs.core.async.macros :refer [go]])
  (:require
    [clojure.browser.repl :as repl]
    [cljs-http.client :as http]
    [cljs.core.async :refer [<!]]))

(defn log [sth]
  (.log js/console (pr-str sth)))

(defn ^:export init []
  (repl/connect "http://localhost:9000/repl")
  (go
    (let [response (<! (http/get "/cheshire-cat"))]
      (log (:body response)))))