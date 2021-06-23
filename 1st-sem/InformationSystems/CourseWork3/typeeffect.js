((selector, configs) => {
  //pass argugemts during method call. first arggument=name of class/id, second argument=configurations
  //=> is a lambda function, shorter way of saying "function (selector,configs) {...}"
  "object" == (selector.typeeffects = configs());
})(this, () => {
  //this keyword is referred to as parent object
  return ((selector) => {
    var configs = (n) => {
      let i = { load: {} }; //used let instead of var for limited scoping
      return selector[n].call(i.load, i, i.load, configs), i.load;
    };
    return configs(0);
  })([
    //start of js array object creation
    (selector, configs, s) => {
      var i = (() => {
          let selector = (selector, configs) => {
            for (let s = 0; s < configs.length; s++) {
              let n = configs[s];
              Object.defineProperty(selector, n.key, n);
            }
          };
          return (configs, s, n) => {
            return (
              s && selector(configs.prototype, s),
              n && selector(configs, n),
              configs
            );
          };
        })(),
        r = s(1),
        a = (() => {
          function selector(configs, s) {
            r.initializer.load(this, s, configs), this.begin();
          }
          return (
            i(selector, [
              {
                //for accessing array objects using keys
                key: "begin",
                value: function () {
                  var selector = this;
                  this.insertCursor(),
                    (this.timeout = setTimeout(() => {
                      selector.typewrite(
                        selector.strings[selector.sequence[selector.arrayPos]],
                        selector.strPos
                      );
                    }, this.startDelay));
                },
              },
              {
                key: "typewrite",
                value: function (selector, configs) {
                  var s = this;
                  var n = this.humanizer(this.typeSpeed),
                    i = 1;
                  this.timeout = setTimeout(() => {
                    let n = 0;
                    s.timeout = setTimeout(() => {
                      configs >= selector.length //check if typed=length of string or trying string has been completed
                        ? s.doneTyping(selector, configs)
                        : s.keepTyping(selector, configs, i);
                    }, n);
                  }, n);
                },
              },
              {
                key: "keepTyping",
                value: function (selector, configs, s) {
                  0 === configs && null, (configs += s);
                  let n = selector.substr(0, configs);
                  this.replaceText(n), this.typewrite(selector, configs);
                },
              },
              {
                //stop typing, find back delay and start deleting(substringing/backspacing)
                key: "doneTyping",
                value: function (selector, configs) {
                  var s = this;
                  (this.arrayPos === this.strings.length - 1 &&
                    (this.loop === !1 || this.curLoop === this.loopCount)) ||
                    (this.timeout = setTimeout(() => {
                      s.backspace(selector, configs);
                    }, this.backDelay));
                },
              },
              {
                key: "backspace",
                value: function (selector, configs) {
                  var s = this;
                  let n = this.humanizer(this.backSpeed);
                  this.timeout = setTimeout(() => {
                    var n = selector.substr(0, configs);
                    if ((s.replaceText(n), s.smartBackspace)) {
                      let i = s.strings[s.arrayPos + 1];
                      i && n === i.substr(0, configs)
                        ? (s.stopNum = configs)
                        : (s.stopNum = 0);
                    }
                    configs > s.stopNum
                      ? (configs--, s.backspace(selector, configs))
                      : configs <= s.stopNum &&
                        (s.arrayPos++,
                        s.arrayPos === s.strings.length
                          ? ((s.arrayPos = 0),
                            //run again if strings array elements have ended iterating
                            s.begin())
                          : s.typewrite(
                              s.strings[s.sequence[s.arrayPos]],
                              configs
                            ));
                  }, n);
                },
              },
              {
                //control typing speed like a normal human
                key: "humanizer",
                value: function (selector) {
                  return Math.round((Math.random() * selector) / 2) + selector;
                },
              },
              {
                //replace text one by one instead of whole string at once
                key: "replaceText",
                value: function (selector) {
                  this.el.textContent = selector;
                },
              },
              {
                //whether to insert cursor character while script is running
                key: "insertCursor",
                value: function () {
                  this.showCursor &&
                    (this.cursor || //prevent from creating n no. of cursor chars at n no. of iterations
                      ((this.cursor = document.createElement("span")), //creating span tag using DOM
                      (this.cursor.className = "typed-cursor"),
                      (this.cursor.innerHTML = "|"),
                      this.el.parentNode.insertBefore(
                        this.cursor,
                        this.el.nextSibling //next siblings are next neighbouring elements belonging to same parent object
                      )));
                },
              },
            ]),
            selector
          );
        })();
      (configs["default"] = a), (selector.load = configs["default"]);
    },
    (selector, configs, s) => {
      let n = (selector) => {
        //used let instead of var for strict typing
        return { default: selector };
      };
      let r = Object.assign,
        o = (() => {
          function selector(selector, configs) {
            for (let s = 0; s < configs.length; s++) {
              let n = configs[s];
              Object.defineProperty(selector, n.key, n);
            }
          }
          return (configs, s, n) => {
            return (
              s && selector(configs.prototype, s),
              n && selector(configs, n),
              configs
            );
          };
        })(),
        a = s(2),
        u = n(a),
        l = (() => {
          function selector() {}
          return (
            o(selector, [
              {
                key: "load",
                value: (selector, configs, s) => {
                  if (
                    ((selector.el = document.querySelector(s)),
                    (selector.options = r({}, u["default"], configs)),
                    (selector.showCursor = selector.options.showCursor),
                    (selector.typeSpeed = selector.options.typeSpeed),
                    (selector.backSpeed = selector.options.backSpeed),
                    (selector.smartBackspace = selector.options.smartBackspace),
                    (selector.backDelay = selector.options.backDelay),
                    (selector.strings = selector.options.strings.map(
                      (selector) => {
                        return selector.trim();
                      }
                    )))
                  ) {
                  }
                  (selector.strPos = 0),
                    (selector.arrayPos = 0),
                    (selector.stopNum = 0),
                    (selector.loop = selector.options.loop),
                    (selector.loopCount = selector.options.loopCount),
                    (selector.curLoop = 0),
                    (selector.sequence = []);
                  for (let text in selector.strings)
                    selector.sequence[text] = text; //foreach loop
                },
              },
            ]),
            selector
          );
        })();
      configs.initializer = new l();
    },
    (selector, configs) => {
      let s = {
        //as a local variable, let is same as var except strict typing
        startDelay: 0,
        //to not delete same charsequence and rewrite it again in next iteration
        smartBackspace: 1,
        //delay when removing(substring) charsequence or string, giving visitors some time to read the content
        backDelay: 700,
        //whether to keep restarting typing after an array has been completely iterated
        loop: 1,
        //whether to show cursor character "|"
        showCursor: 1,
      };
      (configs["default"] = s), (selector.load = configs["default"]);
    },
  ]);
});
