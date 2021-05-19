import unittest
import setup
import os

class MyTestCase(unittest.TestCase):
    def test_should_list_all_content_of_a_files_in_a_directory(self):
        test_contents = setup.get_content_of_files("example")
        self.assertEqual(type(test_contents), list)
        self.assertEqual(len(test_contents), 21)

    def test_should_generate_an_map_with_words_as_keys_and_files_as_value(self):
        test_contents = setup.get_content_of_files("example")
        test_resources = setup.resources_generator(test_contents)
        self.assertEqual(len(test_resources["bellator"]), 9)
        self.assertIn("example/after-the-harvest.txt", test_resources["2001"])
        self.assertEqual(len(test_resources["baby"]), 1)

    def test_should_save_resources_after_script_run(self):
        test_contents = setup.get_content_of_files("example")
        test_resources = setup.resources_generator(test_contents)
        setup.save_resources(test_resources)
        self.assertIn("resources", os.listdir())
        self.assertIn("harvest.txt", os.listdir("resources"))


if __name__ == '__main__':
    unittest.main()
