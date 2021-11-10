# TVTuner
Tool to tune your TV

Basically some Selenium scripts to click various buttons on TradingView website.
I have implemented general functionality like:
1) open input tab of a strategy
2) fiddle with said input entries
3) reload and parse the profitability, amount of orders etc etc etc from panel below.
4) Genetic Algo selects the bestest inputs and minmaxes them further (by the idea)  
5) entries and buttons are hardcoded to no avail.
6) code will break at will

**IMPORTANT NOTE**

If you try to use this, log into TradingView via Google profile and move profile folder somewhere else, because I couldn't figure how to log using cookies. Refer to comments in HelloSelenum.java file.

Also there was another important python piece of code that was hosted locally using Docker and I can't find it anymore. Whoops.

I wont be using or maintaining this anymore, there are way better tools to backtest your strategies, but it was a nice back on the envelope experiment.
