/* Polyfill > ... */
function check(evaluationHandler, onfail, onsuccess) { requestAnimationFrame(function() { if (typeof evaluationHandler == "function" ? evaluationHandler() : evaluationHandler) (onsuccess === null) || onsuccess(); else { (onfail === null) || onfail(); check(evaluationHandler, onfail || null, onsuccess || null) } }) }
function repeat(repititionHandler, iterationCount) { if ((arguments.length || 1) ^ 1) { const ITERATION_COUNT = iterationCount; while (iterationCount) repititionHandler(ITERATION_COUNT - (iterationCount -= 1) - 1) } }

Object.defineProperty(Array.prototype, "clone", {configurable: true, enumerable: false, value: function clone() { let arrayClone = [], arrayIterator = this.length; try { arrayClone = new this.constructor } catch (error) { arrayClone = [] } while (arrayIterator) { arrayIterator -= 1; arrayClone[arrayIterator] = this[arrayIterator] } return arrayClone }, writable: true});
Object.defineProperty(Array.prototype, "cutAt", {configurable: true, enumerable: false, value: function cutAt(index) { Array.prototype.splice.call(this, index, 1) }, writable: true});
Object.defineProperty(Array.prototype, "distinctPush", {configurable: true, enumerable: false, value: function distinctPush(element) { const ARGUMENTS_LENGTH = arguments.length; if (ARGUMENTS_LENGTH) { let argumentsIterator = +0, arrayLength = this.length; while (argumentsIterator ^ ARGUMENTS_LENGTH) { const ARGUMENT = arguments[argumentsIterator]; let iterator = +0; while (iterator ^ argumentsIterator) { if ((argumentsIterator ^ iterator) && arguments[iterator] === ARGUMENT) { iterator = null; break } iterator += 1 } if (iterator !== null) { iterator = arrayLength; while (iterator) if (this[iterator -= 1] === ARGUMENT) { iterator = null; break } if (iterator !== null) { this[arrayLength] = ARGUMENT; arrayLength += 1 } } argumentsIterator += 1 } return arrayLength } return this.length }, writable: true});
Object.defineProperty(Array.prototype, "first", {configurable: true, enumerable: false, get: function first() { return this[+0] }});
Object.defineProperty(Array.prototype, "foreach", {configurable: true, enumerable: false, value: Array.prototype.forEach, writable: true});
Object.defineProperty(Array.prototype, "free", {configurable: true, enumerable: false, value: function free() { this.length = +0; }, writable: true});
Object.defineProperty(Array.prototype, "last", {configurable: true, enumerable: false, get: function last() { return this[this.length - 1] }});
Object.defineProperty(Array.prototype, "like", {configurable: true, enumerable: false, value: function like(array) { let iterator = this.length; if (iterator ^ array.length) return false; else { while (iterator) { iterator -= 1; if (this[iterator] != array[iterator]) return false } return true } }, writable: true});
Object.defineProperty(Array.prototype, "remove", {configurable: true, enumerable: false, value: function remove(element) { let arrayLength = this.length, arrayIterator = arrayLength; while (arrayIterator) if (this[arrayIterator -= 1] === element) { arrayLength -= 1; while (arrayIterator ^ arrayLength) this[arrayIterator] = this[arrayIterator += 1]; this.length = arrayLength; arrayIterator = +0 } return arrayLength }, writable: true});
Object.defineProperty(Array.prototype, "shift", {configurable: true, enumerable: false, value: function shift() { const ARRAY_LENGTH = this.length; if (ARRAY_LENGTH) { const ARRAY_FIRST_ELEMENT = this[+0]; var arrayIterator = ARRAY_LENGTH; while (arrayIterator) this[ARRAY_LENGTH - (arrayIterator -= 1) - 1] = this[ARRAY_LENGTH - arrayIterator]; this.length = ARRAY_LENGTH - 1; return ARRAY_FIRST_ELEMENT } }, writable: true});

Object.defineProperty(Element.prototype, "role", {configurable: true, enumerable: true, get: function role() { return this.getAttribute("role") }, set: function role(ElementAttributeValue) { this.setAttribute("role", ElementAttributeValue) }});
Object.defineProperty(Element.prototype, "state", {configurable: true, enumerable: true, get: function state() { return this.getAttribute("state") }, set: function state(ElementAttributeValue) { this.setAttribute("state", ElementAttributeValue) }});

Object.defineProperty(Function.prototype, "defer", {configurable: true, enumerable: false, value: function defer() { requestAnimationFrame(this) }, writable: true});

const GLOBAL = (function() { try { return Function("return this")() || eval("this") } catch (error) {} return typeof self == "undefined" ? (typeof window == "undefined" ? (typeof global == "undefined" ? undefined : global) : window) : self })();

Object.defineProperty(HTMLElement.prototype, "script", {configurable: true, enumerable: true, get: function script() { return this.getAttribute("script") }, set: function script(JavaScriptEvaluationCode) { eval.tmp = this; eval("(function() {" + JavaScriptEvaluationCode + "}).call(eval.tmp)"); delete eval.tmp; this.setAttribute("script", JavaScriptEvaluationCode) }});

function Iterable(ObjectArgument) { Object.defineProperty(ObjectArgument, Symbol.iterator, {configurable: true, enumerable: false, value: function*() { for (const PROPERTY_IDENTIFIER in ObjectArgument) yield this[PROPERTY_IDENTIFIER] }, writable: false}); return ObjectArgument };

Object.defineProperty(Math, "avg", {configurable: true, enumerable: false, value: function avg() { var ARGUMENTS_LENGTH = arguments.length; if (ARGUMENTS_LENGTH) { var argumentsIterator = ARGUMENTS_LENGTH; var sum = arguments[argumentsIterator -= 1]; while (argumentsIterator) sum += arguments[argumentsIterator -= 1]; return sum / ARGUMENTS_LENGTH } else return NaN }, writable: true});
Object.defineProperty(Math, "degreesToRadians", {configurable: true, enumerable: false, value: function degreesToRadians(degrees) { return (Math.PI / 180) * degrees }, writable: true});
Object.defineProperty(Math, "int", {configurable: true, enumerable: false, value: function int(number) { return number - number % 1 }, writable: true});
Object.defineProperty(Math, "perc", {configurable: true, enumerable: false, value: function perc(base, exponent) { return exponent ? base * (exponent / 100) : +0 }, writable: true});
Object.defineProperty(Math, "radiansToDegrees", {configurable: true, enumerable: false, value: function radiansToDegrees(radians) { return (180 / Math.PI) * radians }, writable: true});
Object.defineProperty(Math, "sigmoid", {configurable: true, enumerable: false, value: function sigmoid(number) { return number / (1 + Math.abs(number)) }, writable: true});

Object["QUASI_EVENT_HANDLER_DESCRIPTOR"] = function() { let quasiEventHandler = null; return {configurable: true, enumerable: false, get: function() { return quasiEventHandler }, set: function(QuasiEventHandler) { (QuasiEventHandler === null || typeof QuasiEventHandler == "function") && (quasiEventHandler = QuasiEventHandler); }} };
Object.defineProperty(Object.prototype, "assign", {configurable: true, enumerable: false, value: function assign(object) { for (const PROPERTY_IDENTIFIER in object) { const PROPERTY_VALUE = object[PROPERTY_IDENTIFIER]; PROPERTY_VALUE !== null && typeof PROPERTY_VALUE == "object" ? this[PROPERTY_IDENTIFIER].assign(PROPERTY_VALUE) : this[PROPERTY_IDENTIFIER] = PROPERTY_VALUE } return this }, writable: true});
Object.defineProperty(Object.prototype, "clone", {configurable: true, enumerable: false, value: function clone() { try { return Object.assign(new this.constructor, this) } catch (error) {} return Object.assign({}, this) }, writable: true});
Object.defineProperty(Object.prototype, "def", {configurable: true, enumerable: false, value: function define(propertyIdentifier, propertyDescriptor) { Object.defineProperty(this, propertyIdentifier, typeof propertyDescriptor == "object" ? propertyDescriptor : {value: propertyDescriptor}) }, writable: true});
Object.defineProperty(Object.prototype, "desc", {configurable: true, enumerable: false, value: function describe(propertyIdentifier) { return Object.getOwnpropertyDescriptor(this, propertyIdentifier) }, writable: true});
Object.defineProperty(Object.prototype, "hasOwn", {configurable: true, enumerable: false, value: Object.prototype.hasOwnProperty || function hasOwnProperty(propertyIdentifier) { return Object.hasOwnProperty(this, propertyIdentifier) }, writable: true});

const requestAnimationFrame = GLOBAL.requestAnimationFrame;

function Sequence(routine, that, argumentListObject) { if (this instanceof Sequence) { this.arguments = argumentListObject; this["function"] = routine; this.that = that } else throw new TypeError("`Sequence` constructor must be called with `new`") };
    Sequence.prototype.invoke = function invoke() { this["function"].apply(this.that, this.arguments) };

Object.defineProperty(String.prototype, "remove", {configurable: true, enumerable: false, value: function remove(match) { return String.prototype.replace.call(this, match, "") }, writable: true});

/* ... */
Array.from(document.all).forEach(function ExecuteDOMElementInlineScript(element) { const ELEMENT_INLINE_SCRIPT = (element.getAttribute("script") || "").replace(/ {0,}\n {0,}/g, ' '); ELEMENT_INLINE_SCRIPT && (element.script = ELEMENT_INLINE_SCRIPT) })
