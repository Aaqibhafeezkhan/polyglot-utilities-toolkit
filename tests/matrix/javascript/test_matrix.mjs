import assert from "node:assert/strict";
import fs from "node:fs";
import { unique, sum, average, groupBy } from "../../../utilities/collections/javascript/collection_utils.js";
import { isEmpty, capitalize, reverseString, isValidEmail, normalizeWhitespace, toTitleCase } from "../../../utilities/strings/javascript/string_utils.js";
import { clamp, isNumeric, minValue, maxValue } from "../../../utilities/numbers/javascript/basic_utils.js";
import { parseDate, daysBetween } from "../../../utilities/dates/javascript/basic_utils.js";
import { isNonEmpty, isEmail, isWithinRange } from "../../../utilities/validation/javascript/basic_utils.js";

const cases = JSON.parse(fs.readFileSync(new URL("../fixtures/core-utility-cases.json", import.meta.url), "utf8"));

assert.deepEqual(unique(cases.collections.unique.input), cases.collections.unique.expected);
assert.equal(sum(cases.collections.sum.input), cases.collections.sum.expected);
assert.equal(average(cases.collections.average.input), cases.collections.average.expected);
assert.equal(average(cases.collections.emptyAverage.input), cases.collections.emptyAverage.expected);
assert.deepEqual(groupBy([{ group: "a", value: 1 }, { group: "b", value: 2 }, { group: "a", value: 3 }], "group"), {
  a: [{ group: "a", value: 1 }, { group: "a", value: 3 }],
  b: [{ group: "b", value: 2 }]
});

assert.equal(isEmpty(""), true);
assert.equal(capitalize(cases.strings.capitalize.input), cases.strings.capitalize.expected);
assert.equal(reverseString(cases.strings.reverse.input), cases.strings.reverse.expected);
assert.equal(isValidEmail(cases.strings.validEmail.input), cases.strings.validEmail.expected);
assert.equal(isValidEmail(cases.strings.invalidEmail.input), cases.strings.invalidEmail.expected);
assert.equal(normalizeWhitespace(cases.strings.normalizeWhitespace.input), cases.strings.normalizeWhitespace.expected);
assert.equal(toTitleCase(cases.strings.titleCase.input), cases.strings.titleCase.expected);

assert.equal(clamp(...cases.numbers.clampLow.input), cases.numbers.clampLow.expected);
assert.equal(clamp(...cases.numbers.clampHigh.input), cases.numbers.clampHigh.expected);
assert.equal(clamp(...cases.numbers.clampBoundary.input), cases.numbers.clampBoundary.expected);
assert.equal(isNumeric(cases.numbers.numeric.input), cases.numbers.numeric.expected);
assert.equal(isNumeric(cases.numbers.nonNumeric.input), cases.numbers.nonNumeric.expected);
assert.equal(minValue(cases.numbers.min.input), cases.numbers.min.expected);
assert.equal(maxValue(cases.numbers.max.input), cases.numbers.max.expected);

assert.ok(parseDate(cases.dates.valid.input));
assert.equal(parseDate(cases.dates.invalid.input), undefined);
assert.equal(daysBetween(cases.dates.daysBetween.start, cases.dates.daysBetween.end), cases.dates.daysBetween.expected);
assert.ok(parseDate(cases.dates.localDateTime.input));

assert.equal(isNonEmpty(cases.validation.nonEmpty.input), cases.validation.nonEmpty.expected);
assert.equal(isNonEmpty(cases.validation.empty.input), cases.validation.empty.expected);
assert.equal(isEmail(cases.validation.validEmail.input), cases.validation.validEmail.expected);
assert.equal(isEmail(cases.validation.invalidEmail.input), cases.validation.invalidEmail.expected);
assert.equal(isWithinRange(...cases.validation.rangeLowBoundary.input), cases.validation.rangeLowBoundary.expected);
assert.equal(isWithinRange(...cases.validation.rangeHighBoundary.input), cases.validation.rangeHighBoundary.expected);
assert.equal(isWithinRange(...cases.validation.rangeOutside.input), cases.validation.rangeOutside.expected);
