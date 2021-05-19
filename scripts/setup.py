import sys
import os
import re
import shutil


def get_content_of_files(directory_path: str) -> dict:
    directory = os.listdir(directory_path)
    contents = {}
    for file in directory:
        with open(os.path.join(directory_path, file)) as f:
            contents[f.name] = f.readlines()
    return contents


def resources_generator(contents_map: dict) -> dict:
    resources_map = {}
    for filename, contents in contents_map.items():
        words = set([w for w in extract_words(contents)])
        for word in words:
            content = resources_map.get(word, [])
            content.append(filename)
            resources_map[word] = content
    return resources_map


def extract_words(lines):
    word_splitter = lambda x: re.sub(r'\W+', ' ', x).lower().split()
    for line in lines:
        words = word_splitter(line)
        for word in words:
            yield word


def save_resources(resources_map: dict):
    if "resources" in os.listdir():
        shutil.rmtree("resources")
    os.mkdir("resources")
    for word, filenames in resources_map.items():
        with open(f"resources/{word}.txt", "w+") as f:
            f.write(" ".join(set(filenames)))


if __name__ == '__main__':
    if len(sys.argv) != 2:
        raise Exception("É preciso informar o diretório onde se encontram os arquivos")
    path = sys.argv[1]
    file_contents = get_content_of_files(path)
    searcher_map = resources_generator(file_contents)
    save_resources(searcher_map)
