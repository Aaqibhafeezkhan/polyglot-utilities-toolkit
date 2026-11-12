import importlib.util
import json
import pathlib
import unittest

ROOT = pathlib.Path(__file__).resolve().parents[3]

def load_module(path):
    spec = importlib.util.spec_from_file_location(path.stem, path)
    module = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(module)
    return module

cases = json.loads((ROOT / "tests/matrix/fixtures/core-utility-cases.json").read_text(encoding="utf-8"))
collections = load_module(ROOT / "utilities/collections/python/collection_utils.py")
strings = load_module(ROOT / "utilities/strings/python/string_utils.py")
numbers = load_module(ROOT / "utilities/numbers/python/basic_utils.py")
dates = load_module(ROOT / "utilities/dates/python/basic_utils.py")
validation = load_module(ROOT / "utilities/validation/python/basic_utils.py")

class CrossLanguageMatrixTest(unittest.TestCase):
    def test_collections(self):
        c = cases["collections"]
        self.assertEqual(collections.unique(c["unique"]["input"]), c["unique"]["expected"])
        self.assertEqual(collections.sum_values(c["sum"]["input"]), c["sum"]["expected"])
        self.assertEqual(collections.average(c["average"]["input"]), c["average"]["expected"])
        self.assertEqual(collections.average(c["emptyAverage"]["input"]), c["emptyAverage"]["expected"])

    def test_strings(self):
        s = cases["strings"]
        self.assertEqual(strings.capitalize(s["capitalize"]["input"]), s["capitalize"]["expected"])
        self.assertEqual(strings.reverse_string(s["reverse"]["input"]), s["reverse"]["expected"])
        self.assertEqual(strings.is_valid_email(s["validEmail"]["input"]), s["validEmail"]["expected"])
        self.assertEqual(strings.is_valid_email(s["invalidEmail"]["input"]), s["invalidEmail"]["expected"])
        self.assertEqual(strings.normalize_whitespace(s["normalizeWhitespace"]["input"]), s["normalizeWhitespace"]["expected"])
        self.assertEqual(strings.to_title_case(s["titleCase"]["input"]), s["titleCase"]["expected"])

    def test_numbers(self):
        n = cases["numbers"]
        self.assertEqual(numbers.clamp(*n["clampLow"]["input"]), n["clampLow"]["expected"])
        self.assertEqual(numbers.clamp(*n["clampHigh"]["input"]), n["clampHigh"]["expected"])
        self.assertEqual(numbers.clamp(*n["clampBoundary"]["input"]), n["clampBoundary"]["expected"])
        self.assertEqual(numbers.is_numeric(n["numeric"]["input"]), n["numeric"]["expected"])
        self.assertEqual(numbers.is_numeric(n["nonNumeric"]["input"]), n["nonNumeric"]["expected"])
        self.assertEqual(numbers.min_value(n["min"]["input"]), n["min"]["expected"])
        self.assertEqual(numbers.max_value(n["max"]["input"]), n["max"]["expected"])

    def test_dates(self):
        d = cases["dates"]
        self.assertIsNotNone(dates.parse_date(d["valid"]["input"]))
        self.assertIsNone(dates.parse_date(d["invalid"]["input"]))
        self.assertEqual(dates.days_between(d["daysBetween"]["start"], d["daysBetween"]["end"]), d["daysBetween"]["expected"])
        self.assertIsNotNone(dates.parse_date(d["localDateTime"]["input"]))

    def test_validation(self):
        v = cases["validation"]
        self.assertEqual(validation.is_non_empty(v["nonEmpty"]["input"]), v["nonEmpty"]["expected"])
        self.assertEqual(validation.is_non_empty(v["empty"]["input"]), v["empty"]["expected"])
        self.assertEqual(validation.is_email(v["validEmail"]["input"]), v["validEmail"]["expected"])
        self.assertEqual(validation.is_email(v["invalidEmail"]["input"]), v["invalidEmail"]["expected"])
        self.assertEqual(validation.is_within_range(*v["rangeLowBoundary"]["input"]), v["rangeLowBoundary"]["expected"])
        self.assertEqual(validation.is_within_range(*v["rangeHighBoundary"]["input"]), v["rangeHighBoundary"]["expected"])
        self.assertEqual(validation.is_within_range(*v["rangeOutside"]["input"]), v["rangeOutside"]["expected"])

        # Extended regression coverage: is_non_empty
        self.assertFalse(validation.is_non_empty(""))
        self.assertFalse(validation.is_non_empty("   \t\n  "))
        self.assertFalse(validation.is_non_empty(None))
        self.assertFalse(validation.is_non_empty(0))
        self.assertFalse(validation.is_non_empty([]))
        self.assertTrue(validation.is_non_empty("a"))
        self.assertTrue(validation.is_non_empty("  valid text  "))

        # Extended regression coverage: is_email
        self.assertFalse(validation.is_email(""))
        self.assertFalse(validation.is_email(None))
        self.assertFalse(validation.is_email(123))
        self.assertFalse(validation.is_email("plainaddress"))
        self.assertFalse(validation.is_email("@missingusername.com"))
        self.assertFalse(validation.is_email("username@.com"))
        self.assertFalse(validation.is_email("username@domain."))
        self.assertFalse(validation.is_email("user@domain@domain.com"))
        self.assertTrue(validation.is_email("test.user@sub.domain.org"))

        # Extended regression coverage: is_within_range
        self.assertTrue(validation.is_within_range(0, 0, 10))
        self.assertTrue(validation.is_within_range(10, 0, 10))
        self.assertTrue(validation.is_within_range(5.5, 0.0, 10.0))
        self.assertTrue(validation.is_within_range(-5, -10, 0))
        self.assertTrue(validation.is_within_range(7, 7, 7))
        self.assertFalse(validation.is_within_range(-0.1, 0, 10))
        self.assertFalse(validation.is_within_range(10.1, 0, 10))
        # Non-coercing behavior
        self.assertFalse(validation.is_within_range("5", 0, 10))
        self.assertFalse(validation.is_within_range(True, 0, 10))
        self.assertFalse(validation.is_within_range(False, 0, 10))
        self.assertFalse(validation.is_within_range(None, 0, 10))

if __name__ == "__main__":
    unittest.main()
